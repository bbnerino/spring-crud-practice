@Library('docker') _
pipeline {
    agent any

    environment {
        IMAGE_NAME = "test2"
        DOCKER_IMAGE = "bbnerino/test2"
        DOCKER_CREDENTIALS = "docker-hub"
        DOCKER_REGISTRY = "https://index.docker.io/v1/"
        TARGET_HOST = "-p 40100 bbnerino@121.170.208.217"
        ContainerPort = "80"
        LocalPort = "40004"
        DOCKER_USER="bbnerino"
        DOCKER_PASS="bb27655100"
    }

    stages {
         stage('Deploy') {
            steps {
                sshagent(credentials: ['SSH-Agent-Key']) {
                sh """
                    ssh -o StrictHostKeyChecking=no ${TARGET_HOST} '
                        docker login -u ${DOCKER_USER} -p ${DOCKER_PASS}
                        docker pull ${DOCKER_IMAGE}
                        docker stop ${IMAGE_NAME}
                        docker rm ${IMAGE_NAME}
                        docker run -d --name ${IMAGE_NAME} -p ${LocalPort}:${ContainerPort} ${DOCKER_IMAGE}
                    '
                """
                }
            }
        }
    }
}