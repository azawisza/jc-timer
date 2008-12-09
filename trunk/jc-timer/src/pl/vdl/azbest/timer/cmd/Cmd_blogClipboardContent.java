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
package pl.vdl.azbest.timer.cmd;

import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.ImageData;

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.blogger.RPCCapture;
import pl.vdl.azbest.timer.gui.GUIFacade;
import pl.vdl.azbest.timer.gui.Shell_BlogEntry;
import pl.vdl.azbest.timer.gui.Shell_BlogSettings;
import pl.vdl.azbest.timer.gui.Shell_Statistics;

public class Cmd_blogClipboardContent implements Command {
	private  Object clip =null;
	public void execute() {

		Conf.getInstance().getDisplay().syncExec(new Runnable() {
			public void run() {
				 clip = RPCCapture.getInstance().capture();
			}
		});
		if (clip == null) {
			Conf.getInstance().getDisplay().syncExec(new Runnable() {
				public void run() {
					GUIFacade
					.getInstance().
					showDialog(
							"Clipboard is empty, or contains not supported data\n Please copy text or image");
				}
			});

		} else if (clip instanceof String) {
			final String txt = (String) clip;
			Conf.getInstance().getDisplay().syncExec(new Runnable() {
				public void run() {
					Shell_BlogEntry entry = new Shell_BlogEntry();
					entry.openSWTWidget();
					entry.insertInitialPostText(txt);
				}
			});

		} else {
			if (clip instanceof ImageData) {
				class ImageSender implements Runnable {
					Logger logger = Logger.getLogger(getClass().getName());

					public void run() {
						logger.info("blog image sender started ...");
						RPCCapture.getInstance().saveIMGToBlog((ImageData) clip);
						logger.info("blog image sender send image ...");
					}
				}
				Thread t = new Thread(new ImageSender());
				t.start();

				Conf.getInstance().getDisplay().syncExec(new Runnable() {
					public void run() {
						GUIFacade
						.getInstance()
						.showDialog(
								"Image sent to blog ...");
					}
				});

			}
		}

	}
}
