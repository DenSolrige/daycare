FROM gradle

COPY . /workspace

WORKDIR /workspace

RUN gradle task customFatJar

WORKDIR /workspace/build/libs

EXPOSE 8080

ENTRYPOINT ["java","-jar","Daycare-App-0.0.1-SNAPSHOT.jar"]
