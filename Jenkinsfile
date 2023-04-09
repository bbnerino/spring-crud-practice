@Library('docker') _
pipeline {
    agent any

    environment {
        IMAGE_NAME = "test2"
        DOCKER_IMAGE = "bbnerino/test2"
        DOCKER_CREDENTIALS = "docker-hub"
        DOCKER_REGISTRY = "https://index.docker.io/v1/"
        TARGET_HOST = "bbnerino@heyhey.i234.me"
        ContainerPort = "80"
        LocalPort = "40004"
        DOCKER_USER="bbnerino"
        DOCKER_PASS="bb27655100"
    }

    stages {
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