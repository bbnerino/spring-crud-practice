pipeline {
    agent {
        docker {
            image 'gradle:7.2.0-jdk11' // Gradle과 JDK 11을 설치한 도커 이미지를 사용
        }
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build' // Gradle로 애플리케이션 빌드
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build("myapp:${env.BUILD_ID}") // Docker 이미지를 빌드하고, 환경변수를 통해 빌드 ID를 태그로 사용
                }
            }
        }

        stage('Push to Docker Registry') {
            steps {
                withDockerRegistry(credentialsId: 'my-docker-registry-credentials', url: 'https://index.docker.io/v1/') {
                    sh "docker login -u ${dockerCredentialsUsr} -p ${dockerCredentialsPwd}" // Docker 레지스트리에 로그인
                    sh "docker push myapp:${env.BUILD_ID}" // 빌드한 Docker 이미지를 레지스트리에 푸시
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                // Deploy Docker image to Kubernetes cluster
                // Kubernetes 클러스터에 Docker 이미지 배포하는 스크립트 실행
            }
        }
    }
}
