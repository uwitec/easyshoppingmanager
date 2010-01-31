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

	private TrayItem trayItem; // 托盘项
	private Image trayImage; // 托盘图标

	public HookSystemTray() {
	}

	// 创建系统托盘
	public void createSystemTray(final IWorkbenchWindow window) {
		initTrayItem(window); // 初始化托盘项
		if (trayItem != null) {
			trayPopupMenu(window); // 弹出托盘菜单项
			trayMinimize(window); // 最小化窗口到托盘
		}
	}

	// 初始化托盘项的文字和图标
	private void initTrayItem(IWorkbenchWindow window) {

		// 获得系统托盘
		final Tray tray = window.getShell().getDisplay().getSystemTray();
		trayItem = new TrayItem(tray, SWT.NONE);
		trayImage = ImageBuffer.getInstance().getImage(
				IAppConstants.APPLICATION_ID, IImagePath.APP_TRAY_ICON);
		trayItem.setImage(trayImage);
	}

	// 托盘弹出菜单
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

	// 构造托盘菜单项
	private void fillTrayItem(MenuManager trayMenu,
			final IWorkbenchWindow window) {

		Action exitSystemAction = new Action("退出系统", AbstractUIPlugin
				.imageDescriptorFromPlugin(IAppConstants.APPLICATION_ID,
						IImagePath.EXIT)) {
			public void run() {
				PlatformUI.getWorkbench().close();
			}
		};

		trayMenu.add(new LogoffAction());
		trayMenu.add(exitSystemAction);
	}

	// 最小化程序到托盘
	private void trayMinimize(final IWorkbenchWindow window) {
		window.getShell().addShellListener(new ShellAdapter() {
			public void shellIconified(ShellEvent e) {
				window.getShell().setVisible(false);
			}
		});
	}

	// 最小化程序窗口
	public void windowMinimized(final Shell shell) {
		shell.setMinimized(true);
		shell.setVisible(false);
	}

	public void dispose() {
		if (trayItem != null)
			trayItem.dispose();
	}
}
