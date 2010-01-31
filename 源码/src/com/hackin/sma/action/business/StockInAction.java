package com.hackin.sma.action.business;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class StockInAction extends Action implements IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;
	
	public static final String ID = "com.hackin.stroemanager.action.StockInAction";
	
	public StockInAction(IWorkbenchWindow workbenchWindow) {
		
		if(workbenchWindow == null) {
			throw new IllegalArgumentException();
		}
		
		this.workbenchWindow = workbenchWindow;
		setId(ID);
		setActionDefinitionId(ID);
		setText("采购入库");
		
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
