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
                    sh 'mvn test sonar:sonar'
            }
        }
		
		stage ('Run') {

            steps {
                    sh 'mvn package'
					sh 'mvn exec:java -Dexec.mainClass="com.covid"'
            }
        }


    }
	
	
}