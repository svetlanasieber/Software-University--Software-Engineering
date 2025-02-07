// SPDX-License-Identifier: MIT
pragma solidity 0.8.28;

contract Crowdfunding {

    struct Campaign {
        uint256 id;
        string title;
        uint256 goalAmount;
        uint256 totalContributed;
        uint256 endTime;
    }

    uint256 private idCampaign;
    // Id of campaign to campaign info
    mapping(uint256 => Campaign) public campaigns;   
    // Id of campaign => contributor address => contributor balance
    mapping(uint256 => mapping(address => uint256)) public campaignToContributorsBalance;

    event Contribution(address backer, uint256 units);
    event Withdrawal(string titleCampaign, address contributor, uint256 units);
    event CampaingCreated(uint256 idCampaign, string title, uint256 goalAmount, uint256 endTime);

    // User can create crowd funding campaign 
    function createCampaign(string calldata title, uint256 goalAmount, uint256 endTime) external {
        require(bytes(title).length <= 100, "Title too long");
        require(goalAmount != 0, "Invalid zero amount");
        require(endTime > block.timestamp, "Unix endTime should be in future");

        Campaign memory newCampaign = Campaign({
            id: idCampaign,
            title: title,
            goalAmount: goalAmount,
            totalContributed: 0,
            endTime: block.timestamp + endTime
        });

        campaigns[idCampaign] = newCampaign;
        idCampaign += 1;

        emit CampaingCreated(newCampaign.id, newCampaign.title, newCampaign.goalAmount, newCampaign.endTime);
    }

    // Users can contribute to specific campaign with specific number of units
    function contribute(uint256 campaignId, uint256 units) external {
        require(units != 0, "Zero is not a valid contribution");
    
        campaigns[campaignId].totalContributed += units;
        campaignToContributorsBalance[campaignId][msg.sender] += units;
        
        emit Contribution(msg.sender, units);
    } 

    // Check if campaign endTime has expired
    function isCampaignActive(uint256 campaignId) public view returns (bool) {
        return campaigns[campaignId].endTime >= block.timestamp;
    }

    // Check if campaign goal is reached
    function isGoalReached(uint256 campaignId) public view returns (bool) {
        return campaigns[campaignId].totalContributed >= campaigns[campaignId].goalAmount;
    }

    // Refund allowed if the goal is not met by endTime
    function isForRefund(uint256 campaignId) internal view returns (bool) {
        return !isCampaignActive(campaignId) && !isGoalReached(campaignId);
    }

    // Users can fully withdraw their funds if campaign expired and goal not reached
    function withdraw(uint256 campaignId) external {
        require(isForRefund(campaignId), "Campaign is still active");
        require(campaignToContributorsBalance[campaignId][msg.sender] > 0, "Not a contributor");
    
        // Get user units before resetting to zero
        uint256 userUnits = campaignToContributorsBalance[campaignId][msg.sender];
        
        campaignToContributorsBalance[campaignId][msg.sender] = 0;
        campaigns[campaignId].totalContributed -= userUnits;

        emit Withdrawal(campaigns[campaignId].title, msg.sender, userUnits);
    }
}
