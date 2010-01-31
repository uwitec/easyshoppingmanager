package com.hackin.sma.application;

import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * 
 * 负责应用程序生命周期管理
 * 
 * @author Hackin
 *
 */
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {

	private static final String PERSPECTIVE_ID = "com.hackin.storemanager.perspective";

    public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    public void initialize(IWorkbenchConfigurer configurer) {
    	
        super.initialize(configurer);
        
        //设置应用程序每次退出时保存当前窗口状态，并在下次启动时应用
        configurer.setSaveAndRestore(false);
        
        //设置启动时显示进度条
        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_PROGRESS_ON_STARTUP, true);
        
        //设置启动时显示欢迎画面
        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_INTRO, true);
        
    }

    /**
     * 打开默认的透视图
     */
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
}
