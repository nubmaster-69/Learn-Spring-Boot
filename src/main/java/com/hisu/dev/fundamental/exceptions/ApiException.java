package com.hisu.dev.fundamental.exceptions;

import java.time.ZonedDateTime;

public record ApiException(String message, ZonedDateTime timestamp) {}