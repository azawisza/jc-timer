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

import org.apache.log4j.Logger;


/**
 * Exact bindings to popular APIs
 */
public class BlogClient {
	private static BlogClient instance;

	private static Logger logger = Logger.getLogger(BlogClient.class);

	private BlogClient() {
		logger.info("BlogClient instance created");
	}

	public static BlogClient getInstance() {
		logger.debug("BlogClient call");
		if (instance == null) {
			instance = new BlogClient();
			return instance;
		} else {
			return instance;
		}
	}

	public boolean sendPost(BlogPost blogPost) {
		return false;
	}

	/** Uses wp.uploadFile */
	public boolean wp_uploadFile(Object file) {
		return false;
	}

	/** Uses metaWeblog.newMediaObject */
	public boolean mw_newMediaObject(Object mediaObject) {
		return false;
	}

	/** blogger.newPost */
	public boolean bg_newPost(BlogPost newPost) {
		return false;
	}

	/** wp.getCategories */
	public Object wp_getCategories() {
		return new Object();
	}

	/** demo.addTwoNumbers */
	public int demo_addTwoNumbers() {
		return 1;
	}

	public boolean sendImage() {
		return false;
	}

	public boolean executeXMLRPCCommand() {
		return false ;
	}
}
