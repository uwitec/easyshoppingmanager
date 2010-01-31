package com.hackin.sma.application;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.hackin.sma.utility.IAppConstants;

/**
 * 
 * 负责应用程序窗口生命周期的管理 每一个应用程序都需要一个WorkbenchWindowAdvisor来控制窗口界面的UI元素。
 * 
 * @author Hackin
 * 
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void postWindowOpen() {

		// 设置窗口自动居中
		Shell shell = getWindowConfigurer().getWindow().getShell();
		Rectangle screenSize = Display.getDefault().getClientArea();
		Rectangle frameSize = shell.getBounds();
		shell.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	public void preWindowOpen() {

		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

		// 窗口设定为800x600
		configurer.setInitialSize(new Point(800, 600));

		// 窗口只显示最小化、关闭按钮
		configurer.setShellStyle(SWT.MIN | SWT.CLOSE);

		// 暂时不显示工具栏
		configurer.setShowCoolBar(false);

		// 显示状态栏
		configurer.setShowStatusLine(true);

		// 设置窗口标题
		configurer.setTitle(IAppConstants.MAIN_WINDOW_TITLE);
	}
	
	public void dispose() {
		
	}
}
