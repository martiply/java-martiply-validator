package com.martiply.validator;

import java.util.List;

public interface ValidationError {

     public List<String> getErrors();
     public boolean isIgnored();
}
