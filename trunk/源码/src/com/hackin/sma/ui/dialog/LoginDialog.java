
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

	// ���öԻ��򴰿ڱ����ͼ��
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("�û������֤");
		newShell.setImage(ImageBuffer.getInstance().getImage(IAppConstants.APPLICATION_ID, IImagePath.TEMP));
	}
	
	// �����Ի��������
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
		userNameLabel.setText("�û���");
		userNameLabel.setImage(ImageBuffer.getInstance().getImage(IAppConstants.APPLICATION_ID, IImagePath.TEMP));
		
		usernameText = new Text(container, SWT.BORDER);
		usernameText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		//------------------
		final CLabel passwordLabel = new CLabel(container, SWT.NONE);
		passwordLabel.setText("��   ��");
		passwordLabel.setImage(ImageBuffer.getInstance().getImage(IAppConstants.APPLICATION_ID, IImagePath.TEMP));
		
		passwordText = new Text(container, SWT.BORDER);
		passwordText.setEchoChar('*');
		passwordText.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		return container;
	}

	// �����Ի���ť
	protected void createButtonsForButtonBar(Composite parent) {
		
		createButton(parent, IDialogConstants.OK_ID, "��¼", true);
		createButton(parent, IDialogConstants.CANCEL_ID, "�˳�", false);
	}
	
	// �ж��û������Ƿ�Ϊ��
	protected void okPressed() {
		
		String username = usernameText.getText();
		String password = passwordText.getText();
		
		MessageBox msgBox;
		
		if(username == null || username.trim().length() == 0) {
			msgBox = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
			msgBox.setText("��ʾ");
			msgBox.setMessage("�������û�����");
			msgBox.open();
			usernameText.setFocus();
			return;
		}
		
		if(password == null || password.trim().length() == 0) {
			msgBox = new MessageBox(getShell(), SWT.ICON_ERROR | SWT.OK);
			msgBox.setText("��ʾ");
			msgBox.setMessage("���������룡");
			msgBox.open();
			passwordText.setFocus();
			return;
		}
		
		super.okPressed();
	}
	
	// ���öԻ����ʼ����С
	protected Point getInitialSize() {
		
//		return super.getInitialSize();
		return new Point(260, 165);
	}

}
