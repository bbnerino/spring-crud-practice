pipeline {
    agent any
    
    stages {
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
//         stage('Test') {
//             steps {
//                 sh './gradlew test'
//             }
//         }
        stage('Dockerize') {
            steps {
                sh 'docker build -t test2 .'
                sh 'docker tag test2 bbnerino/test2'
            }
        }
        stage('Push to Registry') {
            steps {
                withDockerRegistry(credentialsId: 'docker-hub', url: 'https://registry.hub.docker.com') {
                    sh 'docker push bbnerino/test2'
                }
            }
        }
//         stage('Deploy') {
//             steps {
//                 sh 'kubectl apply -f deployment.yaml'
//             }
//         }
    }
}