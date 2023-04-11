@Library('docker') _
pipeline {
    agent any

    environment {
        IMAGE_NAME = "test3"
        DOCKER_IMAGE = "bbnerino/test3"
        DOCKER_CREDENTIALS = "docker-hub"
        DOCKER_REGISTRY = "https://index.docker.io/v1/"
        TARGET_HOST = "bbnerino@heyhey.i234.me"
        ContainerPort = "3333"
        LocalPort = "3333"
        DOCKER_USER="bbnerino"
        DOCKER_PASS="bb27655100"
    }

    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Dockerize') {
            steps {
                sh 'docker build -t ${IMAGE_NAME} .'
                sh 'docker tag ${IMAGE_NAME} ${DOCKER_IMAGE}'
            }
        }
        stage('Push to Registry') {
            steps {
                withDockerRegistry([credentialsId: "${DOCKER_CREDENTIALS}", url: "${DOCKER_REGISTRY}"]) {
                    sh 'docker push ${DOCKER_IMAGE}'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh """
                    ssh -o StrictHostKeyChecking=no -i ~/.ssh/id_rsa ${TARGET_HOST} '
                        export PATH=$PATH:/usr/bin
                        docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
                        docker pull ${DOCKER_IMAGE}
                        docker stop ${IMAGE_NAME} || true
                        docker rm ${IMAGE_NAME} || true
                        docker run -d --name ${IMAGE_NAME} -p ${LocalPort}:${ContainerPort} ${DOCKER_IMAGE}
                    '
                """
            }
        }
    }
}