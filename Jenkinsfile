pipeline{

	environment {
	registry = "rafdev0904/ecommerce"
	registryCredential = 'dockerhub_id'
	dockerImage = ''
	}

	agent any

	stages {

	    stage ('Fetch GIT Repository') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/master']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/rizkipa0904/mini-project-alta.git']]
                ])
            }
        }

		stage('Building our image') {
			steps{
				script {
					dockerImage = docker.build registry + ":$BUILD_NUMBER"
				}
			}
		}

		stage('Deploy our image') {
			steps{
				script {
					docker.withRegistry( '', registryCredential ) {
					dockerImage.push()
					}
				}
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}