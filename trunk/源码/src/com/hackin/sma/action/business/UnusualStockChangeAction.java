package com.hackin.sma.action.business;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class UnusualStockChangeAction extends Action implements
		IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;
	
	public static final String ID = "com.hackin.stroemanager.action.UnusualStockChangeAction";
	
	public UnusualStockChangeAction(IWorkbenchWindow workbenchWindow) {
		
		if(workbenchWindow == null) {
			throw new IllegalArgumentException();
		}
		
		this.workbenchWindow = workbenchWindow;
		setId(ID);
		setActionDefinitionId(ID);
		setText("�ǳ�����䶯");
		
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
