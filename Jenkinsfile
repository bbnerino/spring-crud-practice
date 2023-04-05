pipeline {
    agent any

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
                withDockerRegistry(credentialsId: 'my-docker-registry-credentials', url: 'https://index.docker.io/v1/') {
                    sh "docker login -u ${dockerCredentialsUsr} -p ${dockerCredentialsPwd}"
                    sh "docker push myapp:${env.BUILD_ID}"
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                // Deploy Docker image to Kubernetes cluster
                // ...
            }
        }
    }
}
