package com.hackin.sma.action.basicinfo;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class ManageCustomersAction extends Action implements IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;
	
	public static final String ID = "com.hackin.stroemanager.action.ManageCustomersAction";
	
	public ManageCustomersAction(IWorkbenchWindow workbenchWindow) {
		
		if(workbenchWindow == null) {
			throw new IllegalArgumentException();
		}
		
		this.workbenchWindow = workbenchWindow;
		setId(ID);
		setActionDefinitionId(ID);
		setText("�ͻ�");
		
	}
	
	public void run() {
		
		if(workbenchWindow == null) {
			return;
		}
		
		//�򿪶Ի���
		
	}
	
	public void dispose() {
		workbenchWindow = null;
	}

}
