package com.hackin.sma.action.business;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

public class NonbusinessImcomeAndOutcomeAction extends Action implements
		IWorkbenchAction {

	private IWorkbenchWindow workbenchWindow;
	
	public static final String ID = "com.hackin.stroemanager.action.NonbusinessImcomeAndOutcomeAction";
	
	public NonbusinessImcomeAndOutcomeAction(IWorkbenchWindow workbenchWindow) {
		
		if(workbenchWindow == null) {
			throw new IllegalArgumentException();
		}
		
		this.workbenchWindow = workbenchWindow;
		setId(ID);
		setActionDefinitionId(ID);
		setText("��ҵ����֧");
		
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
