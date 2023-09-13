#! /bin/bash

echo "> 8080 port kill && Auto build"

REPOSITORY=/var/app

# 8080 포트를 사용하는 프로세스의 PID를 검색
echo ", 8080 port 사용하는 애플리케이션 pid 확인"
Auto_PID=$ ps -ef | awk '/:8080/ { print $1 }'

# 만약 해당 포트를 사용하는 프로세스가 존재하면 종료
if [ ! -z "$Auto_PID" ]; then    
    echo "애플리케이션을 종료합니다."

#애플리케이션을 강제로 종료하고, 종료 후 5초 동안 대기
    kill -9 $Auto_PID
    sleep 5
    
else
# 8080 port의 PID가 비어 있으면 실행
	echo "현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
fi

echo "> app.jar위치 디렉토리로 이동"
cd $REPOSITORY

echo "> Build 파일 복사"
cp $REPOSITORY/app.jar $REPOSITORY/playlist_be.jar

echo "> 새 애플리케이션 배포"
JAR_NAME=playlist_be.jar

# 백그라운드 실행
echo "› JAR Name: $JAR_NAME"
nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 & 



# deply script는 반드시 playlist.be에서 실행되어야만 합니다.
