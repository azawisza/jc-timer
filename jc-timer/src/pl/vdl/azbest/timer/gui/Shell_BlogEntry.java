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
package pl.vdl.azbest.timer.gui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Button;

import pl.vdl.azbest.timer.blogger.RPCCapture;
import pl.vdl.azbest.timer.cmd.Cmd_blogPostSave;
import pl.vdl.azbest.timer.cmd.Command;
import pl.vdl.azbest.timer.cmd.Invoker;

public class Shell_BlogEntry extends SWTElement {

	 //private Shell sShell = null; //
	// @jve:decl-index=0:visual-constraint="10,10"
	private Group group = null;
	private Label label = null;
	private Text text = null;
	private Text textArea = null;
	private ToolBar toolBar = null;
	private Group group1 = null;
	private Button button = null;
	private Button button1 = null;

	/**
	 * This method initializes sShell
	 */
	protected void createSShell() {
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		sShell = new Shell();
		sShell.setText("Shell");
		createToolBar();
		Label filler1 = new Label(sShell, SWT.NONE);
		createGroup();
		sShell.setLayout(gridLayout2);
		Label filler = new Label(sShell, SWT.NONE);
		createGroup1();
		sShell.setSize(new Point(499, 283));
	}

	/**
	 * This method initializes group
	 *
	 */
	private void createGroup() {
		GridData gridData2 = new GridData();
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.verticalAlignment = GridData.FILL;
		GridData gridData1 = new GridData();
		gridData1.horizontalSpan = 2;
		gridData1.verticalAlignment = GridData.FILL;
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.grabExcessVerticalSpace = true;
		gridData1.horizontalAlignment = GridData.FILL;
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		group = new Group(sShell, SWT.NONE);
		group.setLayout(gridLayout);
		group.setLayoutData(gridData2);
		label = new Label(group, SWT.NONE);
		label.setText("Post Title");
		text = new Text(group, SWT.BORDER);
		text.setLayoutData(gridData);
		Label filler2 = new Label(group, SWT.NONE);
		textArea = new Text(group, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		textArea.setLayoutData(gridData1);
		textArea.addMouseListener(new org.eclipse.swt.events.MouseAdapter() {
			public void mouseUp(org.eclipse.swt.events.MouseEvent e) {
				System.out.println("mouseUp()"); // TODO Auto-generated Event
				// stub mouseUp()

			}

		});
	}

	/**
	 * This method initializes toolBar
	 *
	 */
	private void createToolBar() {
		GridData gridData3 = new GridData();
		gridData3.horizontalAlignment = GridData.CENTER;
		gridData3.grabExcessHorizontalSpace = false;
		gridData3.grabExcessVerticalSpace = false;
		gridData3.verticalAlignment = GridData.CENTER;
		toolBar = new ToolBar(sShell, SWT.NONE);
		toolBar.setLayoutData(gridData3);
		ToolItem toolItem = new ToolItem(toolBar, SWT.PUSH);
		toolItem.setText("<code></code>");
		toolItem
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<code>", "</code>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem1 = new ToolItem(toolBar, SWT.PUSH);
		toolItem1.setText("<b></b>");
		toolItem1
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<b>", "</b>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem2 = new ToolItem(toolBar, SWT.PUSH);
		toolItem2.setText("<i></i>");
		toolItem2
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<i>", "</i>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem5 = new ToolItem(toolBar, SWT.PUSH);
		toolItem5.setText("<u></u>");
		toolItem5
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<u>", "</u>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem6 = new ToolItem(toolBar, SWT.PUSH);
		toolItem6.setText("<br></br>");
		toolItem6
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<br>", "</br>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem7 = new ToolItem(toolBar, SWT.PUSH);
		toolItem7.setText("<br>");
		toolItem7
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<br>", "<br>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem8 = new ToolItem(toolBar, SWT.PUSH);
		toolItem8.setText("link");
		toolItem8
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<a href=\"www...\" >", "</a>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem3 = new ToolItem(toolBar, SWT.PUSH);
		toolItem3.setText("java");
		toolItem3
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("[surcecode language=\"java\"]",
								"[/sourcecode]");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem4 = new ToolItem(toolBar, SWT.PUSH);
		toolItem4.setText("xml");
		toolItem4
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("[surcecode language=\"xml\"]",
								"[/sourcecode]");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
		ToolItem toolItem9 = new ToolItem(toolBar, SWT.PUSH);
		toolItem9.setText("hide");
		toolItem9
				.addSelectionListener(new org.eclipse.swt.events.SelectionListener() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						addTagString("<spoiler 'show' 'show'>", "</spoiler>");
					}

					public void widgetDefaultSelected(
							org.eclipse.swt.events.SelectionEvent e) {
					}
				});
	}

	/**
	 * This method initializes group1
	 *
	 */
	private void createGroup1() {
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.END;
		gridData4.verticalAlignment = GridData.CENTER;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		group1 = new Group(sShell, SWT.NONE);
		group1.setLayout(gridLayout1);
		group1.setLayoutData(gridData4);
		button = new Button(group1, SWT.NONE);
		button.setText("Post");
		button
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {

						Command com = new Cmd_blogPostSave(textArea.getText(),text.getText());
						Invoker.getInstance().addCommand(com);

					}
				});
		button1 = new Button(group1, SWT.NONE);
		button1.setText("Discard");
		button1
				.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
					public void widgetSelected(
							org.eclipse.swt.events.SelectionEvent e) {
						System.out.println("widgetSelected()"); // TODO
						// Auto-generated
						// Event stub
						// widgetSelected()
						if (Shell_BlogEntry.this
								.showInformationDialogYN("really ?"))
							sShell.close();
					}
				});
	}

	private String addTagString(String stag, String etag) {

		if (textArea.getSelectionText().length() > 0) {
			textArea.insert(stag + textArea.getSelectionText() + etag);
		} else {
			textArea.insert(stag + etag);
		}

		/*
		 * System.err.println("caret pos: " + textArea.getCaretPosition());
		 * System.err.println("selected text:" + textArea.getSelectionText());
		 * System.err.println("text before: " + textArea.getText(0,
		 * textArea.getCaretPosition())); System.err.println("text after: " +
		 * textArea.getText(textArea.getSelectionCount(), textArea
		 * .getText().length()));
		 *
		 * int pos = textArea.getCaretPosition(); String selected =
		 * textArea.getSelectionText(); String txtBefore = textArea.getText(0,
		 * textArea.getCaretPosition()); String txtAfter =
		 * textArea.getText(textArea.getSelectionCount(),
		 * textArea.getText().length()); if (selected.length() > 0) { return
		 * txtBefore + stag + selected + etag + txtAfter; } else { return stag +
		 * etag; }
		 */return "";
	}

	public void insertInitialPostText(String initialTxt) {
		textArea.setText(initialTxt);
	}

	public static void main(String[] args) {
		Shell_BlogEntry be = new Shell_BlogEntry();
		be.openSWTWidgetStandAlone2();

	}

}
