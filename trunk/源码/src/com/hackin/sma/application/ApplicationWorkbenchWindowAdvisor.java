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
 * ����Ӧ�ó��򴰿��������ڵĹ��� ÿһ��Ӧ�ó�����Ҫһ��WorkbenchWindowAdvisor�����ƴ��ڽ����UIԪ�ء�
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

		// ���ô����Զ�����
		Shell shell = getWindowConfigurer().getWindow().getShell();
		Rectangle screenSize = Display.getDefault().getClientArea();
		Rectangle frameSize = shell.getBounds();
		shell.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	public void preWindowOpen() {

		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();

		// �����趨Ϊ800x600
		configurer.setInitialSize(new Point(800, 600));

		// ����ֻ��ʾ��С�����رհ�ť
		configurer.setShellStyle(SWT.MIN | SWT.CLOSE);

		// ��ʱ����ʾ������
		configurer.setShowCoolBar(false);

		// ��ʾ״̬��
		configurer.setShowStatusLine(true);

		// ���ô��ڱ���
		configurer.setTitle(IAppConstants.MAIN_WINDOW_TITLE);
	}
	
	public void dispose() {
		
	}
}
