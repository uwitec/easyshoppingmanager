package com.hackin.sma.application;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.hackin.sma.action.user.LogoffAction;
import com.hackin.sma.utility.IAppConstants;
import com.hackin.sma.utility.IImagePath;
import com.hackin.sma.utility.ImageBuffer;

public class HookSystemTray {

	private TrayItem trayItem; // ������
	private Image trayImage; // ����ͼ��

	public HookSystemTray() {
	}

	// ����ϵͳ����
	public void createSystemTray(final IWorkbenchWindow window) {
		initTrayItem(window); // ��ʼ��������
		if (trayItem != null) {
			trayPopupMenu(window); // �������̲˵���
			trayMinimize(window); // ��С�����ڵ�����
		}
	}

	// ��ʼ������������ֺ�ͼ��
	private void initTrayItem(IWorkbenchWindow window) {

		// ���ϵͳ����
		final Tray tray = window.getShell().getDisplay().getSystemTray();
		trayItem = new TrayItem(tray, SWT.NONE);
		trayImage = ImageBuffer.getInstance().getImage(
				IAppConstants.APPLICATION_ID, IImagePath.APP_TRAY_ICON);
		trayItem.setImage(trayImage);
	}

	// ���̵����˵�
	private void trayPopupMenu(final IWorkbenchWindow window) {

		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				MenuManager trayMenu = new MenuManager();
				Menu menu = trayMenu.createContextMenu(window.getShell());
				fillTrayItem(trayMenu, window);
				menu.setVisible(true);
			}
		});
	}

	// �������̲˵���
	private void fillTrayItem(MenuManager trayMenu,
			final IWorkbenchWindow window) {

		Action exitSystemAction = new Action("�˳�ϵͳ", AbstractUIPlugin
				.imageDescriptorFromPlugin(IAppConstants.APPLICATION_ID,
						IImagePath.EXIT)) {
			public void run() {
				PlatformUI.getWorkbench().close();
			}
		};

		trayMenu.add(new LogoffAction());
		trayMenu.add(exitSystemAction);
	}

	// ��С����������
	private void trayMinimize(final IWorkbenchWindow window) {
		window.getShell().addShellListener(new ShellAdapter() {
			public void shellIconified(ShellEvent e) {
				window.getShell().setVisible(false);
			}
		});
	}

	// ��С�����򴰿�
	public void windowMinimized(final Shell shell) {
		shell.setMinimized(true);
		shell.setVisible(false);
	}

	public void dispose() {
		if (trayItem != null)
			trayItem.dispose();
	}
}
