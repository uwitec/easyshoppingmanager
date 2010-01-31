package com.hackin.sma.action.business;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class SeparateAndCombineGoodsAction extends Action implements
		IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;
	
	public static final String ID = "com.hackin.stroemanager.action.SeparateAndCombineGoodsAction";
	
	public SeparateAndCombineGoodsAction(IWorkbenchWindow workbenchWindow) {
		
		if(workbenchWindow == null) {
			throw new IllegalArgumentException();
		}
		
		this.workbenchWindow = workbenchWindow;
		setId(ID);
		setActionDefinitionId(ID);
		setText("��ֻ������Ʒ");
		
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
