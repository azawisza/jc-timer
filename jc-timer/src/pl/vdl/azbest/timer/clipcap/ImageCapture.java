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
package pl.vdl.azbest.timer.clipcap;

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
import java.util.Locale;
import java.util.Vector;

import org.apache.log4j.Logger;
//import org.apache.xmlrpc.XmlRpcException;
//import org.apache.xmlrpc.client.XmlRpcClient;
//import org.apache.xmlrpc.client.XmlRpcClientConfig;
///import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

//import org.eclipse.swt.SWT;
//import org.eclipse.swt.dnd.Clipboard;
//import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.net.URL;

import pl.vdl.azbest.timer.Conf;

//import redstone.xmlrpc.XmlRpcClient;
//import redstone.xmlrpc.XmlRpcFault;
//import redstone.xmlrpc.util.Base64;

public class ImageCapture {
/*c
	private ImageData imageData = null;

	public static ImageCapture getInstance() {
		if (instance == null) {
			instance = new ImageCapture();
		}
		return instance;
	}

	public void capture() {
	//	Clipboard clipboard = new Clipboard(Conf.getInstance().getDisplay());
		//ImageTransfer imageTransfer = ImageTransfer.getInstance();
		// check if image
		//Object cdata = clipboard.getContents(imageTransfer);
		//if (cdata instanceof ImageData) {
		//	imageData = (ImageData) cdata;
		//}

	}

	public static void main(String[] args) {
		ImageCapture.getInstance().capture();
		ImageCapture.getInstance().saveToFile(null);
	}



	public boolean saveToFile(File dir ) {

		if (imageData == null) {
			logger
					.warn("No image to save. Probably clipboard doesnt contain image or is empty. Make another Print Screen to obtain image and call this method again");
			return false;
		}
		ImageLoader il = new ImageLoader();
		il.data = new ImageData[] { imageData };

		try {

			NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(0);
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,
					new Locale("pl", "PL"));
			DateFormat tf = DateFormat.getTimeInstance(DateFormat.SHORT,
					new Locale("pl", "PL"));

			String time = df.format(c.getTime());
			String date = tf.format(c.getTime());

			logger.info(time + date + c.get(Calendar.SECOND));
			String name = time + "_" + date + "-" + c.get(Calendar.SECOND);
			name = name.replace('.', '-');
			name = name.replace(':', '-');
			name += ".jpeg";

			File file = new File(name);



			FileOutputStream fos = new FileOutputStream(file);
			il.save(fos, SWT.IMAGE_JPEG);
			fos.flush();
			fos.close();

			saveToBlog();

		} catch (IOException E) {
			E.printStackTrace();
			return false;
		}
		return true;
	}

	public void saveToBlog() {
		try {

			// saving to tmp file
			ImageLoader il = new ImageLoader();
			il.data = new ImageData[] { imageData };
			ByteArrayInputStream bis = new ByteArrayInputStream(imageData.data);
			byte ar[] = new byte[bis.available()] ;
			//bis.read(ar);

			HashMap hmIMGQuery = new HashMap();
			hmIMGQuery.put("name", "image.jpg");
			hmIMGQuery.put("type", "");
			hmIMGQuery.put("bits", imageData.data);

			Vector structure = new Vector();
			structure.add(0, "1");
			structure.add(1, "admin");
			structure.add(2, "scjpaslk12");
			structure.add(3, hmIMGQuery);
			// XmlRpcException

			//XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
			//config
				//	.setServerURL(new URL(
							//"http://localhost/wordpress/xmlrpc.php"));
			//XmlRpcClient client = new XmlRpcClient();
			//client.setConfig(config);

			 * Object[] params = new Object[] { "", "admin", "scjpaslk12",
			 * "image/jpeg", "name", exp };

			///Object resultfromQuery = client.execute(
			//		"metaWeblog.newMediaObject", structure);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		//} catch (XmlRpcException e) {
		//	e.printStackTrace();
//
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveToBlog2() throws MalformedURLException {

		 * // obtain blog url rpc String url =
		 * "http://localhost/wordpress/xmlrpc.php"; XmlRpcClient xmlrpcClient =
		 * new XmlRpcClient(url, false); // decoding to Base64 byte[] img =
		 * imageData.data;
		 *
		 * byte[] imgRaw = new byte[img.length]; for (int k = 0; k < img.length;
		 * k++) { imgRaw[k] = img[k]; } char img64[] = Base64.encode(img);
		 * String img64s = new String(img64); String exp = new String(img); try {
		 *
		 *
		 * Object postID = xmlrpcClient.invoke("metaWeblog.newMediaObject", new
		 * Object[] { "0123456789ABCDEF",new Integer(1), "admin", "scjpaslk12", "<title>TITLE</title>NewPostContetnt",new
		 * Boolean(true) }); logger.info(postID); // System.out.print(img64s);
		 * Object postID3 = xmlrpcClient.invoke("metaWeblog.newMediaObject", new
		 * Object[] { new Integer(1), "admin", "scjpaslk12", "image/jpeg",
		 * "name", exp }); } catch (XmlRpcFault e) { e.printStackTrace(); }

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
*/}
