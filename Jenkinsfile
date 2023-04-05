@Library('docker') _
pipeline {
    agent any

    environment {
        IMAGE_NAME = "test2",
        DOCKER_IMAGE = "bbnerino/test2",
        DOCKER_CREDENTIALS = "docker-hub",
        DOCKER_REGISTRY = "https://index.docker.io/v1/"
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
                withDockerRegistry([credentialsId: ${DOCKER_CREDENTIALS}, url: ${DOCKER_REGISTRY}]) {
                    sh 'docker push ${DOCKER_IMAGE}'
                }
            }
        }
        stage('Deploy') {
            steps {
                sshagent(['my-ssh-credential']) {
                    sh '''
                        ssh bbnerino@heyhey.i234.me "docker pull ${DOCKER_IMAGE}"
                        ssh bbnerino@heyhey.i234.me "docker run -d -p 5005:80 --name ${IMAGE_NAME} ${DOCKER_IMAGE}"
                    '''
                }
            }
        }
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }
    }
}