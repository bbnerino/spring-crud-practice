pipeline {
    agent any
    environment {
        REMOTE_ADDRESS = 'heyhey.i234.me -p40100'
        USER = 'bbnerino'
        KEY_FILE = '/path/to/ssh/key'
    }
    stages {
        stage('Build') {
            steps {
                sh './gradlew clean build'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def dockerImage = docker.build("myapp:${env.BUILD_ID}")
                }
            }
        }

        stage('Push to Docker Registry') {
            steps {
                withDockerRegistry(credentialsId: 'bbnerino', url: 'https://index.docker.io/v1/') {
                    sh "docker login -u ${dockerCredentialsUsr} -p ${dockerCredentialsPwd}"
                    sh "docker push myapp:${env.BUILD_ID}"
                }
            }
        }
        stage ('Deploy image to remote server') {
            steps {
                withCredentials([sshUserPrivateKey(credentialsId: 'bbnerino', keyFileVariable: 'KEY_FILE', usernameVariable: 'USER')]) {
                    sh 'ssh -i ${KEY_FILE} ${USER}@${REMOTE_ADDRESS} "docker run -d bbnerino/prac1:latest"'
                }
            }
        }

    }
}
