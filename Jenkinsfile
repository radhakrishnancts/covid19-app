pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                    sh 'mvn compile'
                 }
        }
		
		stage ('Testing Stage') {

            steps {
                    sh 'mvn test'
            }
        }

    }
	
	
}