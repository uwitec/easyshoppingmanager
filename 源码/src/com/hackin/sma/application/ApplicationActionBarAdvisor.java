package com.hackin.sma.application;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;

import com.hackin.sma.action.basicinfo.ManageCustomersAction;
import com.hackin.sma.action.basicinfo.ManageEmployeesAction;
import com.hackin.sma.action.basicinfo.ManageGoodsAction;
import com.hackin.sma.action.basicinfo.ManageSuppliersAction;
import com.hackin.sma.action.business.InventoryStockAction;
import com.hackin.sma.action.business.NonbusinessImcomeAndOutcomeAction;
import com.hackin.sma.action.business.PurchaseOrderAction;
import com.hackin.sma.action.business.PurchaseReturnAction;
import com.hackin.sma.action.business.SalesOrderAction;
import com.hackin.sma.action.business.SalesReturnAction;
import com.hackin.sma.action.business.SeparateAndCombineGoodsAction;
import com.hackin.sma.action.business.StockInAction;
import com.hackin.sma.action.business.StockOutAction;
import com.hackin.sma.action.business.UnusualStockChangeAction;
import com.hackin.sma.action.data.BackupDataAction;
import com.hackin.sma.action.data.RecoverDataAction;
import com.hackin.sma.action.report.DailyStatementAction;
import com.hackin.sma.action.report.MonthlyStatementAction;
import com.hackin.sma.action.user.ChangeUserAction;
import com.hackin.sma.action.user.ManageUsersAction;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.Separator;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// 系统管理
	private IAction navigatorAction;
	private IWorkbenchAction changeUserAction;
	private IWorkbenchAction manageUsersAction;
	private IAction quitAction;

	// 基本信息
	private IWorkbenchAction manageGoodsAction;
	private IWorkbenchAction manageSuppliersAction;
	private IWorkbenchAction manageCustomersAction;
//	private IWorkbenchAction manageEmployeesAction;

	// 业务处理
//	private IWorkbenchAction purchaseOrderAction;
	private IWorkbenchAction stockInAction;
	private IWorkbenchAction purchaseReturnAction;
	
//	private IWorkbenchAction salesOrderAction;
	private IWorkbenchAction stockOutAction;
	private IWorkbenchAction salesReturnAction;
	
	private IWorkbenchAction inventoryStockAction;
	
	private IWorkbenchAction unusualStockChangeAction;
	private IWorkbenchAction separateAndCombineGoodsAction;
//	private IWorkbenchAction nonbusinessIncomeAndOutcomeAction;
	
	// 报表中心
	private IWorkbenchAction dailyStatemnetAction;
	private IWorkbenchAction monthlyStatementAction;
	
	// 数据管理
	private IWorkbenchAction backupDataAction;
	private IWorkbenchAction recoverDataAction;
	
	// 帮助
	private IAction helpContentsAction;
	private IAction aboutAction;	
	
	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(IWorkbenchWindow window) {

		// 系统管理
		navigatorAction = ActionFactory.INTRO.create(window);
		navigatorAction.setText("功能导航");
		register(navigatorAction);

		changeUserAction = new ChangeUserAction(window);
		register(changeUserAction);
		
		manageUsersAction = new ManageUsersAction(window);
		register(manageUsersAction);
		
		quitAction = ActionFactory.QUIT.create(window);
		quitAction.setText("退出");
		register(quitAction);
		

		// 基本信息
		manageGoodsAction = new ManageGoodsAction(window);
		register(manageGoodsAction);
		 
		manageSuppliersAction = new ManageSuppliersAction(window);
		register(manageSuppliersAction);	
		 
		manageCustomersAction = new ManageCustomersAction(window);
		register(manageCustomersAction);	
		 
//		manageEmployeesAction = new ManageEmployeesAction(window);
//		register(manageEmployeesAction);

		// 业务处理
//		purchaseOrderAction = new PurchaseOrderAction(window);
//		register(purchaseOrderAction);
		
		stockInAction = new StockInAction(window);
		register(stockInAction);
		
		purchaseReturnAction = new PurchaseReturnAction(window);
		register(purchaseReturnAction);
		
//		salesOrderAction = new SalesOrderAction(window);
//		register(salesOrderAction);
		
		stockOutAction = new StockOutAction(window);
		register(stockOutAction);
		
		salesReturnAction = new SalesReturnAction(window);
		register(salesReturnAction);
		
		inventoryStockAction = new InventoryStockAction(window);
		register(inventoryStockAction);

		unusualStockChangeAction = new UnusualStockChangeAction(window);
		register(unusualStockChangeAction);
		
		separateAndCombineGoodsAction = new SeparateAndCombineGoodsAction(window);
		register(separateAndCombineGoodsAction);
		
//		nonbusinessIncomeAndOutcomeAction = new NonbusinessImcomeAndOutcomeAction(window);
//		register(nonbusinessIncomeAndOutcomeAction);
		
		// 报表中心
		dailyStatemnetAction = new DailyStatementAction(window);
		register(dailyStatemnetAction);
		
		monthlyStatementAction = new MonthlyStatementAction(window);
		register(monthlyStatementAction);
		
		// 数据管理
		backupDataAction = new BackupDataAction(window);
		register(backupDataAction);
		
		recoverDataAction = new RecoverDataAction(window);
		register(recoverDataAction);
		
		// 帮助
		helpContentsAction = ActionFactory.HELP_CONTENTS.create(window);
		helpContentsAction.setText("用户手册");
		register(helpContentsAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		aboutAction.setText("联系作者");
		register(aboutAction);

	}

	protected void fillMenuBar(IMenuManager menuBar) {

		// 系统管理
		IMenuManager systemManagingMenu = new MenuManager("系统管理");
		menuBar.add(systemManagingMenu);
		
		systemManagingMenu.add(navigatorAction);
		systemManagingMenu.add(changeUserAction);
		systemManagingMenu.add(manageUsersAction);
		systemManagingMenu.add(quitAction);
		
		// 基本信息
		IMenuManager basicInformationMenu = new MenuManager("基本信息");
		menuBar.add(basicInformationMenu);
		
		basicInformationMenu.add(manageGoodsAction);
		basicInformationMenu.add(manageSuppliersAction);
		basicInformationMenu.add(manageCustomersAction);
//		basicInfomationMenu.add(manageEmployeesAction);
		
		// 业务处理
		IMenuManager businessProcessingManager = new MenuManager("业务处理");
		menuBar.add(businessProcessingManager);
		
//		businessProcessingManager.add(purchaseOrderAction);
		businessProcessingManager.add(stockInAction);
		businessProcessingManager.add(purchaseReturnAction);
		businessProcessingManager.add(new Separator());
		
//		businessProcessingManager.add(salesOrderAction);
		businessProcessingManager.add(stockOutAction);
		businessProcessingManager.add(salesReturnAction);
		businessProcessingManager.add(new Separator());
		
		businessProcessingManager.add(inventoryStockAction);
		businessProcessingManager.add(new Separator());
		businessProcessingManager.add(separateAndCombineGoodsAction);
		businessProcessingManager.add(unusualStockChangeAction);
//		businessProcessingManager.add(nonbusinessIncomeAndOutcomeAction);

		// 报表中心
		IMenuManager reportCenterMenuManager = new MenuManager("报表中心");
		menuBar.add(reportCenterMenuManager);
		
		reportCenterMenuManager.add(dailyStatemnetAction);
		reportCenterMenuManager.add(monthlyStatementAction);

		// 数据管理
		IMenuManager dataManagingMenuManager = new MenuManager("数据管理");
		menuBar.add(dataManagingMenuManager);
		
		dataManagingMenuManager.add(backupDataAction);
		dataManagingMenuManager.add(recoverDataAction);
	
		// 帮助
		IMenuManager helpMenuManager = new MenuManager("帮助");
		menuBar.add(helpMenuManager);
		
		helpMenuManager.add(helpContentsAction);
		helpMenuManager.add(aboutAction);

	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		
		IToolBarManager toolBar = new ToolBarManager(SWT.FLAT | SWT.SHADOW_OUT);
		
		
	}

	protected void fillStatusLine(IStatusLineManager statusLine) {

	}

}
