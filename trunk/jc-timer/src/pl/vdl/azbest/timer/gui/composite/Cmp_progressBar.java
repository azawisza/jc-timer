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
package pl.vdl.azbest.timer.gui.composite;

import java.util.ArrayList;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

import pl.vdl.azbest.timer.gui.GUIFacade;

public class Cmp_progressBar extends Composite {

	private ProgressBar progressBar = null;

	public Cmp_progressBar(Composite parent, int style) {
		super(parent, style);
		initialize();
	}

	private void initialize() {
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = GridData.CENTER;
		progressBar = new ProgressBar(this, SWT.SMOOTH | SWT.NONE);
		progressBar.setLayoutData(gridData);
		setSize(new Point(142, 25));
		setLayout(new GridLayout());
		GUIFacade.getInstance().setCmp_progressBar(this);
		progressBar.setMaximum(150);
		progressBar
				.addDisposeListener(new org.eclipse.swt.events.DisposeListener() {
					public void widgetDisposed(
							org.eclipse.swt.events.DisposeEvent e) {
						ArrayList<Cmp_progressBar> bars = GUIFacade
								.getInstance().getCmp_progressBar();
						bars.remove(Cmp_progressBar.this);

					}
				});

	}

	public void advance() {
		if (progressBar.getSelection() < 150)
			progressBar.setSelection(progressBar.getSelection() + 1);
	}

	public void clear() {
		progressBar.setSelection(0);
	}

} // @jve:decl-index=0:visual-constraint="0,0"
