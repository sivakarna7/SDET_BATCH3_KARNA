package pageobjects;

public class HomePageLocators {
	public static String marketPlace = "id=MP_link";
	public static String welcome = "id=welcome";
	
	public static String mainDashboard = "xpath=//*[@id='menu_dashboard_index']/b";
	public static String mainAdmin = "xpath=//*[@id='menu_admin_viewAdminModule']";
	public static String mainPIM = "xpath=//*[@id='menu_pim_viewPimModule']";
	public static String mainLeave = "id=menu_leave_viewLeaveModule";
	public static String mainTime = "id=menu_time_viewTimeModule";
	public static String mainDirectory = "xpath=//*[@id='menu_directory_viewDirectory']";
	public static String mainMaintenance = "xpath=//*[@id='menu_maintenance_purgeEmployee']";
	
	public static String dashboardHdg = "xpath=//*[@id='content']/div/div[1]/h1";
	public static String dashAssignLeave ="xpath=//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[1]";
	public static String dashTimesheets = "xpath=//*[@id='dashboard-quick-launch-panel-menu_holder']/table/tbody/tr/td[3]";
	public static String dashPie="xpath=//*[@id='div_graph_display_emp_distribution']/canvas[1]";
	
	public static String adminUserMgmt = "xpath=//*[@id='menu_admin_UserManagement']";
	public static String adminJob = "xpath=//*[@id='menu_admin_Job']";	
	public static String adminOrganization = "xpath=//*[@id='menu_admin_Organization']";
	public static String adminQualifications = "xpath=//*[@id='menu_admin_Qualifications']";
	public static String adminUsers = "xpath=//*[@id='menu_admin_viewSystemUsers']";
	public static String adminJobTitles = "xpath=//*[@id='menu_admin_viewJobTitleList']";
	
	public static String leaveList ="xpath=//*[@id='menu_leave_viewLeaveList']";
	
	public static String pimEmpName ="xpath=//*[@id='empsearch_employee_name_empName']";
	public static String pimSrchBtn = "xpath=//*[@id='searchBtn']";
	
	public static String cssMainPIM="css=#menu_pim_viewPimModule";
	public static String cssMainTime="css=#menu_time_viewTimeModule";
	public static String cssMainMaintenance="css=#menu_maintenance_purgeEmployee";
	public static String cssDashAssignLeave="css=#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(1) > div";
	public static String cssDashTimeSheet="css=#dashboard-quick-launch-panel-menu_holder > table > tbody > tr > td:nth-child(3) > div";
	public static String cssDashPie="css=#div_graph_display_emp_distribution > canvas.flot-overlay";
}