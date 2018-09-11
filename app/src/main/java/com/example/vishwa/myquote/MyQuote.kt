package com.example.vishwa.myquote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MyQuote{
    @SerializedName("quoteText")
    @Expose
    private var quoteText: String = ""
    @SerializedName("quoteAuthor")
    @Expose
    private var quoteAuthor: String = ""
    @SerializedName("senderName")
    @Expose
    private var senderName: String = ""
    @SerializedName("senderLink")
    @Expose
    private var senderLink: String = ""
    @SerializedName("quoteLink")
    @Expose
    private var quoteLink: String = ""

    fun getQuoteText(): String {
        return quoteText
    }

    fun setQuoteText(quoteText: String) {
        this.quoteText = quoteText
    }

    fun getQuoteAuthor(): String {
        return quoteAuthor
    }

    fun setQuoteAuthor(quoteAuthor: String) {
        this.quoteAuthor = quoteAuthor
    }

    fun getSenderName(): String {
        return senderName
    }

    fun setSenderName(senderName: String) {
        this.senderName = senderName
    }

    fun getSenderLink(): String {
        return senderLink
    }

    fun setSenderLink(senderLink: String) {
        this.senderLink = senderLink
    }

    fun getQuoteLink(): String {
        return quoteLink
    }

    fun setQuoteLink(quoteLink: String) {
        this.quoteLink = quoteLink
    }
}