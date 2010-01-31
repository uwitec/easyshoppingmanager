
package com.hackin.sma.ui.dialog;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.hackin.sma.utility.IAppConstants;
import com.hackin.sma.utility.IImagePath;
import com.hackin.sma.utility.ImageBuffer;

import org.eclipse.swt.widgets.Label;

public class LoginDialog extends Dialog {

	private Text usernameText;
	private Text passwordText;
	
	public LoginDialog(Shell parentShell) {
		super(parentShell);
	}

	// 设置对话框窗口标题和图标
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("用户身份验证");
		newShell.setImage(ImageBuffer.getInstance().getImage(IAppConstants.APPLICATION_ID, IImagePath.TEMP));
	}
	
	// 创建对话框的内容
	protected Control createDialogArea(Composite parent) {
		
		Composite container = (Composite)super.createDialogArea(parent);
		
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginRight = 6;
		container.setLayout(gridLayout);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		//------------------
		final CLabel userNameLabel = new CLabel(container, SWT.None);
		userNameLabel.setText("用户名");
		userNameLabel.setImage(ImageBuffer.getInstance().getImage(IAppConstants.APPLICATION_ID, IImagePath.TEMP));
		
		usernameText = new Text(container, SWT.BORDER);
		usernameText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		//------------------
		final CLabel passwordLabel = new CLabel(container, SWT.NONE);
		passwordLabel.setText("密   码");
		passwordLabel.setImage(ImageBuffer.getInstance().getImage(IAppConstants.APPLICATION_ID, IImagePath.TEMP));
		
		passwordText = new Text(container, SWT.BORDER);
		passwordText.setEchoChar('*');
		passwordText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		return container;
	}

	// 创建对话框按钮
	protected void createButtonsForButtonBar(Composite parent) {
		
		createButton(parent, IDialogConstants.OK_ID, "登录", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "退出", false);
	}
	
	// 判断用户输入是否为空
	protected void okPressed() {
		
		String username = usernameText.getText();
		String password = passwordText.getText();
		
		MessageBox msgBox;
		
		if(username == null || username.trim().length() == 0) {
			msgBox = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
			msgBox.setText("提示");
			msgBox.setMessage("请输入用户名！");
			msgBox.open();
			usernameText.setFocus();
			return;
		}
		
		if(password == null || password.trim().length() == 0) {
			msgBox = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
			msgBox.setText("提示");
			msgBox.setMessage("请输入密码！");
			msgBox.open();
			passwordText.setFocus();
			return;
		}
		
		super.okPressed();
	}
	
	// 设置对话框初始化大小
	protected Point getInitialSize() {
		
//		return super.getInitialSize();
		return new Point(260, 165);
	}

}
