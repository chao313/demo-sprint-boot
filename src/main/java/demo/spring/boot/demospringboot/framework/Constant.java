package demo.spring.boot.demospringboot.framework;

public interface Constant {

	public interface Log {

		String SQL_LOGGER_NAME = "SQL_LOGGER";

	}

	public interface Goods {

	}

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

	public interface Car {
		// 0:加入购物车；1:已购买；2：已取消；3：已删除
		Integer inCar = 0;
		Integer buyed = 1;
		Integer canceled = 2;
		Integer deleted = 3;
	}
	public interface Order {
		// 0 创建成功 1付款，2未付款，3取消，4删除 5过期
		Integer inOrder = 0;
		Integer buyed = 1;
		Integer canceled = 2;
		Integer deleted = 3;
		Integer Expired = 4;
		
	}
	public interface UserRole{
		Integer publicUser = 0;//普通用户
		Integer admin = 1;//管理员
		 
	}
	
	public interface UserStaus{
		Integer commonUser = 0;//普通用户
		Integer desabledUser = 1;//禁用用户
		 
	}
}
