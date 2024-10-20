package com.nourcine.backend.auth;


public class AuthenticationRequest {
    String email;
    String password;

    public static AuthenticationRequestBuilder builder() {
        return new AuthenticationRequestBuilder();
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof AuthenticationRequest)) {
            return false;
        } else {
            AuthenticationRequest other = (AuthenticationRequest)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$email = this.getEmail();
                Object other$email = other.getEmail();
                if (this$email == null) {
                    if (other$email != null) {
                        return false;
                    }
                } else if (!this$email.equals(other$email)) {
                    return false;
                }

                Object this$password = this.getPassword();
                Object other$password = other.getPassword();
                if (this$password == null) {
                    if (other$password != null) {
                        return false;
                    }
                } else if (!this$password.equals(other$password)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AuthenticationRequest;
    }

    public int hashCode() {
        boolean PRIME;
        PRIME = true;
        int result = 1;
        Object $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        Object $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getEmail();
        return "AuthenticationRequest(email=" + var10000 + ", password=" + this.getPassword() + ")";
    }

    public AuthenticationRequest(final String email, final String password) {
        this.email = email;
        this.password = password;
    }

    public AuthenticationRequest() {
    }

    public static class AuthenticationRequestBuilder {
        private String email;
        private String password;

        AuthenticationRequestBuilder() {
        }

        public AuthenticationRequestBuilder email(final String email) {
            this.email = email;
            return this;
        }

        public AuthenticationRequestBuilder password(final String password) {
            this.password = password;
            return this;
        }

        public AuthenticationRequest build() {
            return new AuthenticationRequest(this.email, this.password);
        }

        public String toString() {
            return "AuthenticationRequest.AuthenticationRequestBuilder(email=" + this.email + ", password=" + this.password + ")";
        }
    }
}
