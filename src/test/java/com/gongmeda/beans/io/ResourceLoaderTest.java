package com.gongmeda.beans.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class ResourceLoaderTest {

    @Test
    void test() throws IOException {
        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("application.xml");
        InputStream inputStream = resource.getInputStream();
        assertNotNull(inputStream);
    }
}