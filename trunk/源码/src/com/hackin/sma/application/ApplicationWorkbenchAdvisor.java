package com.hackin.sma.application;

import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * 
 * ����Ӧ�ó����������ڹ���
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
        
        //����Ӧ�ó���ÿ���˳�ʱ���浱ǰ����״̬�������´�����ʱӦ��
        configurer.setSaveAndRestore(false);
        
        //��������ʱ��ʾ������
        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_PROGRESS_ON_STARTUP, true);
        
        //��������ʱ��ʾ��ӭ����
        PlatformUI.getPreferenceStore().setValue(IWorkbenchPreferenceConstants.SHOW_INTRO, true);
        
    }

    /**
     * ��Ĭ�ϵ�͸��ͼ
     */
	public String getInitialWindowPerspectiveId() {
		return PERSPECTIVE_ID;
	}
}
