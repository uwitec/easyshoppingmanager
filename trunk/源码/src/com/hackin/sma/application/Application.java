package com.hackin.sma.application;

import org.eclipse.core.runtime.IPlatformRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import com.hackin.sma.ui.dialog.LoginDialog;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	public Object start(IApplicationContext context) {
		
		//启动Derby数据库服务器
		
		//打开登录界面
		
		//显示主窗口
		Display display = PlatformUI.createDisplay();
//		Platform.endSplash();
		
		try {
					
			LoginDialog loginDialog = new LoginDialog(null);
			if(loginDialog.open() != Window.OK) {
				return IApplication.EXIT_OK;
			}	
			
			int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IApplication.EXIT_RESTART;
			}
			
			return IApplication.EXIT_OK;
			
		} finally {
			display.dispose();
		}
	}

	public void stop() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null)
			return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}
}
