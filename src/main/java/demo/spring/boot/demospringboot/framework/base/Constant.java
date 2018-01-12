package demo.spring.boot.demospringboot.framework.base;

public interface Constant {

	public interface SystemCode {
		String SUCCESS = "0";
		String SUCCESS_MSG = "服务正常";
		String ERROR = "1";
		String ERROR_MSG = "系统有点累~";
		String DAO_OK = "000";// 代表dao正常
		String DAO_OK_MSG = "dao正常";
		String DAO_ERROR = "100";// 代表dao异常
		String DAO_ERROR_MSG = "dao异常";
		String SERVICE_OK = "001";// 代表service正常
		String SERVICE_OK_MSG = "service正常";
		String SERVICE_ERROR = "101";// 代表service异常
		String SERVICE_ERROR_MSG = "service异常";
		String Controller_OK = "002";// 代表controller正常
		String Controller_OK_MSG = "controller正常";
		String Controller_ERROR = "102";// 代表controller异常
		String Controller_ERROR_MSG = "controller异常";
		String User_noLogin = "103";// 代表controller异常
		String User_noLogin_MSG = "用户未登陆";// 代表controller异常
	}

	/**
	 * 0:创建成功，1：user删除，2：hr已读，3：hr驳回，4，hr同意
	 * 
	 * @author chao
	 *
	 */
	public interface ApplyRecordStatus {
		Integer create = 0;
		Integer userDeleted = 1;
		Integer hrReaded = 2;
		Integer hrRefused = 3;
		Integer hrAgreed = 4;
	}
}
