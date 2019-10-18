package com.david.ticketmastertest

import com.david.ticketmastertest.models.events.*

class TestModels {

    companion object {
        fun getEvent(
            name: String = "name",
            type: String = "type"
        ): Events {
            return Events(
                id = "9oiaosidi98923is3i",
                name = name,
                type = type,
                test = true,
                url = "url",
                locale = "locale",
                images = emptyList(),
                sales = getSales(),
                dates = getDates(),
                classifications = emptyList(),
                _links = getLinks(),
                venuesEmbedded = getVenuesEmbedded()
            )
        }

        private fun getDates(): Dates {
            return Dates(
                start = getStart(),
                timezone = "",
                status = getStatus(),
                spanMultipleDays = false
            )
        }

        private fun getStatus(): Status {
            return Status(
                code = ""
            )
        }

        private fun getStart(): Start {
            return Start(
                localDate = "2019-11-25",
                localTime = "",
                dateTime = "",
                dateTBD = false,
                dateTBA = false,
                timeTBA = false,
                noSpecificTime = false
            )
        }

        private fun getVenuesEmbedded(): VenuesEmbedded {
            return VenuesEmbedded(
                venues = listOf(
                    getVenues()
                )
            )
        }

        private fun getVenues(): Venues {
            return Venues(
                name = "",
                type = "",
                id = "",
                test = false,
                url = "",
                locale = "",
                postalCode = "",
                timezone = "",
                city = City(""),
                country = Country("", ""),
                address = Address(""),
                location = Location(0.0, 0.0),
                markets = emptyList(),
                dmas = emptyList(),
                upcomingEvents = UpcomingEvents(0, 0),
                _links = getLinks()
            )
        }

        private fun getLinks(): Links {
            return Links(
                self = getSelf()
            )
        }

        private fun getSelf(): Self {
            return Self(
                href = ""
            )
        }

        private fun getSales(): Sales {
            return Sales(
                public = getPublic()
            )
        }

        private fun getPublic(): Public {
            return Public(
                startDateTime = "",
                startTBD = true,
                endDateTime = ""
            )
        }
    }
}