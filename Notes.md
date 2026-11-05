# Learning Notes

## 2026-11-05 — Validation & exception handling
- **Built:** Bean Validation on CreatePaymentRequest; @RestControllerAdvice with ProblemDetail responses
- **Broke:** GET /payments/9999 returned 500 — "9999" isn't a valid UUID, so MethodArgumentTypeMismatchException fell through to the catch-all handler
- **Fixed:** Added a handler for MethodArgumentTypeMismatchException → 400 with a clear message

## 2026-11-05 — Project setup & first push
- **Built:** Spring Boot 3 / Java 21 project; Payments REST API (create, get, list) with record DTOs
- **Broke:** `git status` failed — "not a git repository"
- **Fixed:** Ran `git init` in the project root first