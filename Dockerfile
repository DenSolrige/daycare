FROM gradle

COPY . /workspace

WORKDIR /workspace

RUN gradle task customFatJar

WORKDIR /workspace/build/libs

EXPOSE 8080

ENTRYPOINT ["java","-jar","Daycare-App-1.0-SNAPSHOT.jar"]
