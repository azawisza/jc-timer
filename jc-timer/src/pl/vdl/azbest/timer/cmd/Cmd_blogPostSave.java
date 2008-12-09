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

import pl.vdl.azbest.timer.Conf;
import pl.vdl.azbest.timer.blogger.RPCCapture;
import pl.vdl.azbest.timer.gui.GUIFacade;
import pl.vdl.azbest.timer.gui.Shell_BlogSettings;
import pl.vdl.azbest.timer.gui.Shell_PsotingBlogPostProgress;

public class Cmd_blogPostSave implements Command {
	private Logger logger = Logger.getLogger(getClass().getName());
	private String txt = "";
	private String title = "";

	public Cmd_blogPostSave(String txt, String title) {
		this.txt = txt;
		this.title = title;
	}

	public void execute() {
		BlogWorker bw = new BlogWorker();
		Thread t = new Thread(bw);
		t.start();
	}

	public class BlogWorker implements Runnable {
		private Logger logger = Logger.getLogger(getClass().getName());
		private Shell_PsotingBlogPostProgress shell = null;
		public void removeUI(){
			shell=null;
		}

		public void run() {
			logger.info("Starting BlogWoker ...");
			GUIFacade.getInstance();

			Conf.getInstance().getDisplay().syncExec(new Runnable() {
				public void run() {
					shell = new Shell_PsotingBlogPostProgress(BlogWorker.this);
					shell.setTitle(title);
					shell.openSWTWidget();
				}
			});

			RPCCapture.getInstance().saveTXTToBlog(txt, title, this);
			logger.info("Blog worker have executed post");
		}

		public void updateUIBlogProgressLabel(final String text) {
			Conf.getInstance().getDisplay().syncExec(new Runnable() {
				public void run() {
					if(shell!= null)shell.setBlogPostinProgressLabel(text);
				}
			});
		}
	}

}
