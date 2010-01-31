package com.hackin.sma.action.basicinfo;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class ManageEmployeesAction extends Action implements IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;
	
	public static final String ID = "com.hackin.stroemanager.action.ManageEmployeesAction";
	
	public ManageEmployeesAction(IWorkbenchWindow workbenchWindow) {
		
		if(workbenchWindow == null) {
			throw new IllegalArgumentException();
		}
		
		this.workbenchWindow = workbenchWindow;
		setId(ID);
		setActionDefinitionId(ID);
		setText("管理员工");
		
	}
	
	public void run() {
		
		if(workbenchWindow == null) {
			return;
		}
		
		//打开对话框
		
	}
	
	public void dispose() {
		workbenchWindow = null;
	}

}
