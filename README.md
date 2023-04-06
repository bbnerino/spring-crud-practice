Jenkins에서 다른 서버에 배포하기 위해서는 다음과 같은 단계를 따르면 됩니다.

배포 대상 서버에 도커를 설치합니다.

Jenkins에서 배포 대상 서버에 로그인할 수 있는 SSH 키를 설정합니다.

배포할 Docker 이미지를 빌드합니다.

빌드한 Docker 이미지를 Docker Hub나 개인 레지스트리에 업로드합니다.

배포 대상 서버에서 Docker 이미지를 다운로드하고 실행합니다.

이를 위해서는 다음과 같은 과정을 수행하면 됩니다.

배포 대상 서버에 Docker를 설치합니다.

$ sudo apt update
$ sudo apt install -y docker.io
배포 대상 서버에서 로그인할 수 있는 SSH 키를 Jenkins에서 설정합니다. SSH 키를 설정하려면 다음 명령어를 수행합니다.

$ ssh-keygen -t rsa
이후에는 해당 키를 배포 대상 서버에 등록합니다. 이를 위해서는 배포 대상 서버에 접속하여 다음 명령어를 수행합니다.

$ cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys
이제 Jenkins에서 배포 대상 서버에 로그인할 수 있는 SSH 키를 사용할 수 있습니다.

Jenkins에서 배포할 Docker 이미지를 빌드합니다. 이미지를 빌드하려면 Dockerfile을 작성하고, 해당 Dockerfile을 빌드하면 됩니다.

$ docker build -t [이미지 이름]:[태그] .
빌드한 Docker 이미지를 Docker Hub나 개인 레지스트리에 업로드합니다.

$ docker login
$ docker tag [이미지 이름]:[태그] [계정 이름]/[이미지 이름]:[태그]
$ docker push [계정 이름]/[이미지 이름]:[태그]
배포 대상 서버에서 Docker 이미지를 다운로드하고 실행합니다.

$ docker pull [계정 이름]/[이미지 이름]:[태그]
$ docker run -p [포트 번호]:[컨테이너 포트 번호] -d [계정 이름]/[이미지 이름]:[태그]
위의 단계를 수행하면 Jenkins에서 빌드한 Docker 이미지를 배포 대상 서버에서 실행할 수 있습니다.

SHA256:KlgwkGDrpIdRkmFfSxZMs1PP5rQkQR5any5EoyFimC8

sudo docker exec -it --user root [컨테이너명] bash
---------------
40000 - jenkins
40004 - server
40022 - db
40100 - ssh
ssh 인증서 생성 
jenkins 설치 폴더 

### ssh 접속
ssh bbnerino@heyhey.i234.me -p40100

Jenkins VM에서 해당 작업을 수행합니다. 이전 단계에서 만든 공개 키를 MasterVM에 복사합니다.

이 단계에서 비밀번호 한번 입력이 필요합니다.
이 후엔 비밀 키를 사용한 접근 시에 비밀번호 입력이 필요 없습니다.
`ssh-copy-id -i ~/.ssh/id_rsa.pub -p 40100 bbnerino@121.170.208.217`

----