/*
 This file is part of JCTimer

    JCTimer is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JCTimer is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JCTimer.  If not, see <http://www.gnu.org/licenses/>.
	author: azbest.pro (azbest.pro@gmail.com)
*/
package pl.vdl.azbest.timer.blogger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.net.URL;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.cmd.Cmd_blogPostSave.BlogWorker;

//import redstone.xmlrpc.XmlRpcClient;
//import redstone.xmlrpc.XmlRpcFault;
//import redstone.xmlrpc.util.Base64;

public class RPCCapture {
	private Logger logger = Logger.getLogger(getClass().getName());

	private static RPCCapture instance = null;

	private RPCCapture() {
	}

	private ImageData imageData = null;

	public static RPCCapture getInstance() {
		if (instance == null) {
			instance = new RPCCapture();
		}
		return instance;
	}

	public Object capture() {
		Clipboard clipboard = new Clipboard(Conf.getInstance().getDisplay());
		ImageTransfer imageTransfer = ImageTransfer.getInstance();
		TextTransfer txtTransfer = TextTransfer.getInstance();
		// check if image
		Object idata = clipboard.getContents(imageTransfer);

		if (idata instanceof ImageData) {
			logger.info("Seting captured data");
			imageData = (ImageData) idata;
			return imageData;
		} else {
			logger.warn("No capture image data received. !!!");
			Object tdata = clipboard.getContents(txtTransfer);
			if (tdata != null) {
				// we have txt data
				return tdata;
			} else {
				logger.error("Only text or image capture supported !");
				return null;
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {
		Object o = RPCCapture.getInstance().capture();
		if (o instanceof String) {
			// RPCCapture.getInstance().saveTXTToBlog((String)o, "auto
			// title",null);
			return;
		}
		if (o instanceof ImageData) {
			RPCCapture.getInstance().saveIMGToBlog((ImageData) o);
			return;
		}
		System.err.println("Error.");

	}

	public boolean saveToFile(File dir) {

		if (imageData == null) {
			logger
					.warn("No image to save. Probably clipboard doesnt contain image or is empty. Make another Print Screen to obtain image and call this method again");

		}
		ImageLoader il = new ImageLoader();
		il.data = new ImageData[] { imageData };

		try {


			String name = Conf.getInstance().getCurrentDate()+".jpg";
			File file = new File(name);

			FileOutputStream fos = new FileOutputStream(file);
			il.save(fos, SWT.IMAGE_JPEG);
			fos.flush();
			fos.close();

		} catch (IOException E) {
			E.printStackTrace();
			return false;
		}
		return true;
	}

	public void saveTXTToBlog(String txt, String title, BlogWorker bworker) {
		Object resultfromQuery = null;
		boolean success = false ;
		try {

			Hashtable data = new Hashtable();
			data.put("title", title);
			data.put("description", txt);

			bworker.updateUIBlogProgressLabel("Data prepared");

			Vector blogPost = new Vector();
			blogPost.add(0, Conf.getInstance().getBlogNumber());
			blogPost.add(1, Conf.getInstance().getBlogUserName());
			blogPost.add(2, Conf.getInstance().getBlogPassword());
			blogPost.add(3, data);
			blogPost.add(true);
			// XmlRpcException

			bworker.updateUIBlogProgressLabel("Post prepared");

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL(Conf.getInstance().getBlogAddress()));
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);
			/*
			 * Object[] params = new Object[] { "", "admin", "passs",
			 * "image/jpeg", "name", exp };
			 */
			bworker.updateUIBlogProgressLabel("Waitng in queue ...");
			synchronized (this) {
				bworker.updateUIBlogProgressLabel("Sending data");
				resultfromQuery = client
						.execute("metaWeblog.newPost", blogPost);
				System.err.println(resultfromQuery);
				success= true;
			}

		} catch (MalformedURLException e) {

			e.printStackTrace();
			bworker.updateUIBlogProgressLabel("URL is not proper");
			success= false;
		} catch (XmlRpcException e) {
			e.printStackTrace();
			bworker
					.updateUIBlogProgressLabel("Connection sucessful but error in blog service. Check console");
			success= false;
		}
		if(success)bworker.updateUIBlogProgressLabel("Sucess: " + resultfromQuery);
	}

	public void saveIMGToBlog(ImageData imageData) {
		try {

			// saving to tmp file
			ImageLoader il = new ImageLoader();
			il.data = new ImageData[] { imageData };
			ByteArrayInputStream bis = new ByteArrayInputStream(imageData.data);
			byte ar[] = new byte[bis.available()];
			// bis.read(ar);

			HashMap hmIMGQuery = new HashMap();
			hmIMGQuery.put("name", Conf.getInstance().getCurrentDate()+".jpeg");
			hmIMGQuery.put("type", "jpg");
			hmIMGQuery.put("bits", openByteStreamToImg(imageData));

			Vector structure = new Vector();
			structure.add(0, "1");
			structure.add(1, "admin");
			structure.add(2, "passwo");
			structure.add(3, hmIMGQuery);
			// XmlRpcException

			XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			config.setServerURL(new URL("http://localhost/ee/xmlrpc.php"));
			XmlRpcClient client = new XmlRpcClient();
			client.setConfig(config);
			/*
			 * Object[] params = new Object[] { "", "admin", "eeaslk12",
			 * "image/jpeg", "name", exp };
			 */
			Object resultfromQuery = client.execute(
					"metaWeblog.newMediaObject", structure);

			logger.info("Image sent sucessful : "+(resultfromQuery));
		} catch (MalformedURLException e) {
			logger.info("Image sent: URL problem");
			e.printStackTrace();
		} catch (XmlRpcException e) {
			logger.info("Image not sent: Blog service problem");
			e.printStackTrace();

		}


	}

	public void saveToBlog2() throws MalformedURLException {

	}

	private byte[] openByteStreamToImg(ImageData idata) {
		if (imageData == null) {
			logger
					.warn("No image to save. Probably clipboard doesnt contain image or is empty. Make another Print Screen to obtain image and call this method again");

		}
		ImageLoader il = new ImageLoader();
		il.data = new ImageData[] { imageData };
		byte imgBits[] = null;
		try {
			File file = new File("img.jpg");

			FileOutputStream fos = new FileOutputStream(file);
			il.save(fos, SWT.IMAGE_JPEG);
			fos.flush();
			fos.close();
			FileInputStream fis = new FileInputStream(file);
			byte bt[] = new byte[(int) file.length()];
			fis.read(bt);
			imgBits = bt;

		} catch (IOException E) {
			E.printStackTrace();
		}
		logger.info("img bytes read: " + imgBits.length);
		return imgBits;

	}

	private byte[] readFile(String path) throws Exception {
		byte bytes[];
		File file = new File(path);
		InputStream in = null;

		in = new FileInputStream(path);
		bytes = new byte[(int) file.length()];
		in.read(bytes);
		in.close();
		return bytes;
	}
}
