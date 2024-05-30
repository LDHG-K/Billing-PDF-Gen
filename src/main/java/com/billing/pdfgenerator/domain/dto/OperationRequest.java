package com.billing.pdfgenerator.domain.dto;
    public class OperationRequest {
        private int valueA;
        private int valueB;
        private char operator;

        public char getOperator() {
            return operator;
        }

        public void setOperator(char operator) {
            this.operator = operator;
        }

        // Getters y setters
        public int getValueA() {
            return valueA;
        }

        public void setValueA(int valueA) {
            this.valueA = valueA;
        }

        public int getValueB() {
            return valueB;
        }

        public void setValueB(int valueB) {
            this.valueB = valueB;
        }
    }
