package playlist.server.consts;

public class StaticVal {
  
  /*
  에러 코드 관련 static 변수들
   */
  public static final Integer BAD_REQUEST = 400;
  public static final Integer UNAUTHORIZED = 401;
  public static final Integer FORBIDDEN = 403;
  public static final Integer NOT_FOUND = 404;
  public static final Integer SERVER_ERROR = 500;
  
  /*
  빌드 환경 관련 static 변수들
   */
  public static final String DEV = "dev";
  public static final String PROD = "prod";
}