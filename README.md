# Playlist BE

## Intellij 필요 설정
-  Settings → Annotation Processing 설정 해야합니다!


## EndPoints

|Mapping| Description                       |  
|:---|:----------------------------------|
|`/health` | NCP TG → Application Health Check |


## Allowed Origin
| URL                          |
|:-----------------------------|
| http://localhost:3000        |
| http://dev.playlist.10duck.kr|
| http://playlist.10duck.kr    |
| https://dev.playlist.10duck.kr|
| https://playlist.10duck.kr   |

## PR Rule
- Push 하기 전 spotless 적용 push
  - 만약 spotless 적용하지 않으면 merge 허가 나지 않으니 꼭 apply 하셔야 합니다....
