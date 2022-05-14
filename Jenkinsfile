
pipeline{

	agent any
	
	stages {
	    
	    stage ('Fetch GIT Repository') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/rizkipa0904/mini-project-alta.git']]
                ])
            }
        }
		
		stage('build') {
			steps {
				sh'docker build -t rafdev0904/ecommerce:v3.1 .'
				
			}
		}
		stage('Login') {

			steps {
				sh 'docker login -u rafdev0904 -p Tkjmhd123'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push rafdev0904/ecommerce:v3.1'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}