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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;


public class Cmd_uiSaveToFile implements Command {
	private String txt;

	private String path;

	private Logger logger = Logger.getLogger(getClass().getName());

	public void execute() {
		// TODO Auto-generated method stub
		logger.info("from button save to file");

		logger.info("from button save to file");
		File f = new File(path);
		if (f.exists())
			return;
		else {
			try {
				f.createNewFile();
				PrintWriter pw = new PrintWriter(f);
				pw.print(txt);
				pw.flush();
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public Cmd_uiSaveToFile(String txt, String path) {
		this.path = path;
		this.txt = txt;
	}

}
