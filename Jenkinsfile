pipeline{

	agent any s
	
	environment {
		dockerhub=credentials('dockerhub_id')
		dockerImage = ''
	}

	stages {

		stage('build') {
			steps {
				sh'docker build -t ecommerce:$BUILD_NUMBER .'

			}
		}

		stage('Login') {

			steps {
				sh 'echo $dockerhub_PSW | docker login -u $dockerhub_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push rafdev0904/nodejsphp'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
